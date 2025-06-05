import org.gradle.api.tasks.SourceSetContainer

plugins {
	java
	id("org.springframework.boot") version "3.5.0"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.main"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(21))
	}
}

repositories {
	mavenCentral()
}

dependencies {
	constraints {
		implementation("org.springframework:spring-webmvc:6.0.13") // versão compatível com Spring Boot 3.5.0
	}

	// Spring Boot Starters
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation") // Bean Validation

	// Flyway migrations
	implementation("org.flywaydb:flyway-core")
	implementation("org.flywaydb:flyway-database-postgresql")

	// Lombok
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	// PostgreSQL driver
	runtimeOnly("org.postgresql:postgresql")

	// DevTools
	developmentOnly("org.springframework.boot:spring-boot-devtools")

	// QueryDSL
	implementation("com.querydsl:querydsl-jpa:5.1.0:jakarta")
	implementation("com.querydsl:querydsl-core:5.1.0")
	annotationProcessor("com.querydsl:querydsl-apt:5.1.0:jakarta")
	annotationProcessor("jakarta.persistence:jakarta.persistence-api")
	annotationProcessor("jakarta.annotation:jakarta.annotation-api")

	//JSONWebToken
	implementation ("io.jsonwebtoken:jjwt-api:0.11.5")
	runtimeOnly ("io.jsonwebtoken:jjwt-impl:0.11.5")
	runtimeOnly ("io.jsonwebtoken:jjwt-jackson:0.11.5")

	//ModelMapper
	implementation ("org.modelmapper:modelmapper:3.0.0")

	//Swagger
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.8")

	// Tests
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

val querydslDir = "$buildDir/generated/querydsl"

// Register generated sources folder
val sourceSets = extensions.getByName("sourceSets") as SourceSetContainer
sourceSets["main"].java.srcDir(querydslDir)

tasks.withType<JavaCompile> {
	options.annotationProcessorGeneratedSourcesDirectory = file(querydslDir)
	options.annotationProcessorPath = configurations.annotationProcessor.get()
}

tasks.withType<Test> {
	useJUnitPlatform()
}
