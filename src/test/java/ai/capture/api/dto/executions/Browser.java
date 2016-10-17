package ai.capture.api.dto.executions;

import org.apache.commons.lang3.builder.*;

/** Browser message. */
public class Browser {
    public String name;
    public String version;

    public static Browser newInstance() {
        Browser browser = new Browser();
        browser.name = "Chrome";
        browser.version = "53.0";
        return browser;
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

        Browser browser = (Browser) o;

        return new EqualsBuilder()
                .append(name, browser.name)
                .append(version, browser.version)
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
