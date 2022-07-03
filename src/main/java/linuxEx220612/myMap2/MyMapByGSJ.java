package linuxEx220612.myMap2;

public class MyMapByGSJ {
    private String key;
    private String value;
    private MyMapByGSJ next;
    private MyMapByGSJ back;

    public MyMapByGSJ() {
        key = null;
        value = null;
        next = null;
        back = null;
    }

    public MyMapByGSJ(String key, String value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.back = null;
    }

    public MyMapByGSJ put(String key, String value) {
        if (this.key == key) {
            System.out.println("이미 있는 key 값 입니다.");
            return this;
        }
        if (this.key == null) {
            this.key = key;
            this.value = value;
            return this;
        } else {
            if (next == null) {
                next = new MyMapByGSJ(key, value);
                next.back = this;
            } else {
                next.put(key, value);
            }
            return this;
        }
    }

    public String get(String key){
        if(this.key.equals(key)){
            return this.value;
        }else{
            if (next == null) return null;
            else return next.get(key);
        }
    }

    public MyMapByGSJ replace(String value, String reValue){
        if(this.key.equals(value)){
            this.value = reValue;
            return this;
        }else {
            if(next == null) return null;
            else return next.replace(value,reValue);
        }
    }

    public MyMapByGSJ show() {
        if(value == null) {
            System.out.println("리스트가 비어있음");
            return this;
        }

        System.out.println("Key : " + this.key +" Value : "+this.value);

        if(this.next == null) return this;
        else return next.show();
    }

    public static void main(String[] args){
        MyMapByGSJ myMap = new MyMapByGSJ();

        myMap.put("ko","SeungJo");
        myMap.put("kim", "sungmin");
        myMap.put("ko","sdfssdf");

        System.out.println(myMap.get("ko"));

        myMap.replace("ko" , "reName");
        myMap.show();
    }

}
