package find_pc.model;

public class ResultLaptop implements Result{
    private String brand;
    private int postId;
    private String sellerName;
    private String model;
    private String sellerSurname;
    private String sellerEmail;
    private double screenSize;
    private String cpu;
    private String gpu;
    private String ram;
    private String memory;
    private int price;
    private double latitude;
    private double longitude;
    private String fullAddress;
    private int sellerId;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerSurname() {
        return sellerSurname;
    }

    public void setSellerSurname(String sellerSurname) {
        this.sellerSurname = sellerSurname;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public String getBrand() {
            return brand;
        }

    public void setBrand(String brand) {
            this.brand = brand;
        }

    public String getModel() {
            return model;
        }

    public void setModel(String model) {
            this.model = model;
        }

    public double getScreenSize() {
            return screenSize;
        }

    public void setScreenSize(double screenSize) {
            this.screenSize = screenSize;
        }

    public String getCpu() {
            return cpu;
        }

    public void setCpu(String cpu) {
            this.cpu = cpu;
        }

    public String getGpu() {
            return gpu;
        }

    public void setGpu(String gpu) {
            this.gpu = gpu;
        }

    public String getRam() {
            return ram;
        }

    public void setRam(String ram) {
            this.ram = ram;
        }

    public String getMemory() {
            return memory;
        }

    public void setMemory(String memory) {
            this.memory = memory;
        }

    public void setImg1(byte[] img1) {
        this.img1 = img1;
    }

    public byte[] getImg3() {
        return img3;
    }

    public void setImg3(byte[] img3) {
        this.img3 = img3;
    }

    private byte[] img1;

    public byte[] getImg2() {
        return img2;
    }

    public void setImg2(byte[] img2) {
        this.img2 = img2;
    }

    private byte[] img2;
        private byte[] img3;

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public String getFullAddress() {
            return fullAddress;
        }

        public void setFullAddress(String fullAddress) {
            this.fullAddress = fullAddress;
        }

        public byte[] getImg1() {
            return img1;
        }

        public int getPrice() {
            return price;
        }
        public void setPrice(int price) {
            this.price = price;
        }
        public int getSellerId() {
            return sellerId;
        }
        public void setSellerId(int sellerId) {
            this.sellerId = sellerId;
        }
}
