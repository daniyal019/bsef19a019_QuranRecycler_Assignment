package haqnawaz.org.navigationdrawer;

public  class Friend {
    private int id;
    private int imageID;
    private String name;


    public Friend(int id, String name, int imageID) {
        this.id = id;
        this.imageID = imageID;
        this.name = name;

    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", imageID=" + imageID +
                ", name='" + name + '\'' +

                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}