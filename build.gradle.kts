import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("org.flywaydb.flyway") version "7.11.0"
	kotlin("jvm") version "1.5.20"
	kotlin("plugin.spring") version "1.5.20"
}

group = "com.account_manager"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_16

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.flywaydb:flyway-core")
	implementation("mysql:mysql-connector-java:8.0.23")
	implementation("org.jetbrains.exposed:exposed-core:0.32.1")
	implementation("org.jetbrains.exposed:exposed-dao:0.32.1")
	implementation("org.jetbrains.exposed:exposed-jdbc:0.32.1")
	implementation("org.springframework.session:spring-session-data-redis")
	implementation("redis.clients:jedis")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "16"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

flyway {
	url = "jdbc:mysql://127.0.0.1:53306/webapp"
	user = "root"
	password = "mysql"
}
