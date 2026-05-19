package com.empresa.pedidos.arquitectura;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.empresa.pedidos")
class ArchitectureTest {

    @ArchTest
    static final ArchRule dominioNoDepende_De_Infraestructura =
            noClasses()
                    .that().resideInAPackage("..dominio..")
                    .should().dependOnClassesThat()
                    .resideInAPackage("..infraestructura..")
                    .because("El dominio no debe conocer la infraestructura (Hexagonal)");

    @ArchTest
    static final ArchRule controladorSoloDepende_De_Facade =
            noClasses()
                    .that().resideInAPackage("..adaptadores.rest..")
                    .should().dependOnClassesThat()
                    .resideInAPackage("..aplicacion..")
                    .because("El controlador REST solo debe comunicarse con la Facade");

    @ArchTest
    static final ArchRule dominioNoDepende_De_Spring =
            noClasses()
                    .that().resideInAPackage("..dominio..")
                    .and().areNotAnnotations()
                    .should().dependOnClassesThat()
                    .resideInAPackage("org.springframework..")
                    .because("El dominio debe ser independiente del framework");
}