package entites;

public class LivestreamInfo {
    private String roomName;
    private int viewerCount;

    public LivestreamInfo(String roomName, int viewerCount) {
        this.roomName = roomName;
        this.viewerCount = viewerCount;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getViewerCount() {
        return viewerCount;
    }

    @Override
    public String toString() {
        return roomName + " : " + viewerCount;
    }
}
