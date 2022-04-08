package fete.bird;

import org.junit.jupiter.api.TestInstance;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Testcontainers
public abstract class TestContainerFixture {
    protected static final GenericContainer mongoDBContainer;
    protected static final Map<String, Object> properties;
    static {
        mongoDBContainer = new GenericContainer(DockerImageName.parse("mongo:4.0.10"))
                .withExposedPorts(27017)
                .withReuse(true);
        mongoDBContainer.start();
        properties = Map.of("mongodb.uri",
                String.format("mongodb://%s:%s", mongoDBContainer.getContainerIpAddress(), mongoDBContainer.getMappedPort(27017)));
    }
}
