package linuxEx220612.myMap2;

public class MyMap {

        private String key;
        private String value;
        private MyMap next;
        private MyMap back;

        public MyMap() {
            key = null;
            value = null;
            next = null;
            back = null;
        }

        public MyMap(String key, String value){
            this.key = key;
            this.value = value;
            this.next = null;
            this.back = null;
        }

        public MyMap put(String key, String value) {
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
                    next = new MyMap(key, value);
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

        public MyMap replace(String value, String reValue){
            if(this.key.equals(value)){
                this.value = reValue;
                return this;
            }else {
                if(next == null) return null;
                else return next.replace(value,reValue);
            }
        }

        public MyMap show() {
            if(value == null) {
                System.out.println("리스트가 비어있음");
                return this;
            }

            System.out.println("Key : " + this.key +" Value : "+this.value);

            if(this.next == null) return this;
            else return next.show();
        }

}
