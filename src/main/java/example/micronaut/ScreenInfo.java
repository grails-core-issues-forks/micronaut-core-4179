package example.micronaut;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import io.micronaut.core.annotation.Introspected;

import java.util.HashMap;
import java.util.Map;

@Introspected
public class ScreenInfo {
    private String id;
    private String title;
    private int width;
    private int height;
    private Map<String, Object> otherInfo;

    public ScreenInfo() {
    }

    public void addOtherInfo(String key, Object value) {
        if (this.otherInfo == null) {
            this.otherInfo = new HashMap<>();
        }
        this.otherInfo.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getOtherInfo() {
        return otherInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setOtherInfo(Map<String, Object> otherInfo) {
        this.otherInfo = otherInfo;
    }
}
