package pl.nwse.iseven.codegen;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedList;
import javax.lang.model.element.Modifier;

public final class IsEvenGenerator {

  public static void main(String[] args) throws IOException {
    final MethodSpec isEvenClassConstructor = MethodSpec.constructorBuilder()
        .addModifiers(Modifier.PRIVATE)
        .build();

    final MethodSpec.Builder isEvenMethodBuilder = MethodSpec.methodBuilder("isEven")
        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
        .addParameter(TypeName.INT, "number")
        .returns(TypeName.BOOLEAN);

    for (int current = 0; current < 10_000_001; current++) {
      isEvenMethodBuilder.beginControlFlow("if (number == $L)", current)
          .addStatement("return $L", current % 2 == 0)
          .endControlFlow();
    }
    isEvenMethodBuilder.addStatement("return false");

    final TypeSpec isEvenClass = TypeSpec.classBuilder("IsEven")
        .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
        .addMethod(isEvenClassConstructor)
        .addMethod(isEvenMethodBuilder.build())
        .build();
    final JavaFile isEvenJavaFile = JavaFile.builder("pl.nwse.iseven", isEvenClass)
        .build();
    isEvenJavaFile.writeTo(Path.of("is-even/src/main/java/"));
  }

}
