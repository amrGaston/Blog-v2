plugins {
	java
	id("org.springframework.boot") version "3.2.1"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.blog"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	runtimeOnly("com.mysql:mysql-connector-j")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.springframework.boot:spring-boot-starter-validation:3.2.2")

	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.16.0")


	implementation("jakarta.xml.bind:jakarta.xml.bind-api:4.0.0")
	implementation("org.glassfish.jaxb:jaxb-runtime:4.0.4")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
