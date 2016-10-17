package ai.capture.api.dto.executions;

import org.apache.commons.lang3.builder.*;

/** Represents the Software under test message. */
public class SoftwareUnderTest {
    public String name;
    public String version;

    public static SoftwareUnderTest newInstance() {
        SoftwareUnderTest sut = new SoftwareUnderTest();
        sut.name = "Frameworkium";
        sut.version = "master";
        return sut;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("version", version)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SoftwareUnderTest that = (SoftwareUnderTest) o;

        return new EqualsBuilder()
                .append(name, that.name)
                .append(version, that.version)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(version)
                .toHashCode();
    }
}
