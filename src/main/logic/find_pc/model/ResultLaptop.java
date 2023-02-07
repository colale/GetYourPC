package find_pc.model;
public class ResultLaptop extends Result{
        private post_sale_ad.model.factory_config_info.GeneralPostInfo generalPostInfo;
        private String brand;
        private String model;

        public post_sale_ad.model.factory_config_info.GeneralPostInfo getGeneralPostInfo() {
            return generalPostInfo;
        }

        public void setGeneralPostInfo(post_sale_ad.model.factory_config_info.GeneralPostInfo generalPostInfo) {
            this.generalPostInfo = generalPostInfo;
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
        private String img1;
        private String img2;
        private String img3;

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

        public String getImg1() {
            return img1;
        }

        public void setImg1(String img1) {
            this.img1 = img1;
        }

        public String getImg2() {
            return img2;
        }

        public void setImg2(String img2) {
            this.img2 = img2;
        }

        public String getImg3() {
            return img3;
        }

        public void setImg3(String img3) {
            this.img3 = img3;
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
