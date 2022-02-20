import java.util.*;

public class EmailSendSystemSolution {
    //buyer send email to seller and cc other buyer and manager
    //buyer seller and manager
    //send email/ receive email/ cc email / memorize the previous buyer
    class Person{
        private String Id;
        private String email;
        private int capacity;
        private int todayReceived;
        List<String> emailReceived;
        public Person(String Id,String email){
             this.Id = Id;
             this.email = email;
             todayReceived = 0;
             emailReceived = new ArrayList<>();
        }
        public String getId(){
            return Id;
        }
        public String getEmail(){
            return email;
        }
        protected void setCapacity(int n){
            capacity = n;
        }
        protected void addTodayReceived(){
            todayReceived++;
        }
        public int getCapacity(){
            return capacity;
        }
        public boolean canReceive(){
            return todayReceived <= capacity;
        }
        public void ReceiveEmail(String message){
            emailReceived.add(message);
        }
    }
    class Buyer extends Person{
          Set<order> orderList;
          private String message;
          public Buyer(String Id,String email){
              super(Id,email);
              orderList = new HashSet<>();
              super.setCapacity(10);
          }
          public String sendMessage(){
              return message;
          }
          public order getOrderNeedtoService(order o){
              if(orderList.contains(o)){
                  return o;
              }else{
                  throw Exception();
              }
          }
    }
    class Seller extends Person{
        List<Product> itemList;
        Map<Product,List<Buyer>> ProductList;
        public Seller(String Id,String email){
            super(Id,email);
            itemList = new ArrayList<>();
            ProductList = new HashMap<>();
        }
        public void addBuyer(){}
        public List<Buyer> returnBuyerList(Product product){
               return ProductList.get(product);
        }
        @Override
        public boolean canReceive(){
            return true;
        }
    }
    class Manager extends Person{
        public Manager(String Id,String email){
            super(Id,email);
            super.setCapacity(100);
        }

    }
    class Product{
        Seller seller;
    }
    class order{
         Seller seller;
         Buyer  buyer;
         Product  product;
    }
    class EmailSend{
        //buyer send email to seller get order and get the email of seller and send message
        // cc to buyer that buy same product
        List<Buyer> buyerNeedService;
        PriorityQueue<Manager> availableManager;
        public EmailSend(){
            //api get the buyer who want to send message;
            order o = new order;
            for(Buyer a:buyerNeedService){
                sendToAll(a,o);
            }
        }
        public void sendToAll(Buyer a,order o){
             order p = a.getOrderNeedtoService(o);
             sendEmail(a,p.seller);
             List<Buyer> BuyerBySame = p.seller.returnBuyerList(p.product);
             for(Buyer same:BuyerBySame){
                 sendEmail(a,same);
             }
             sendEmail(a,availaleManager.peek());
        }
        public void sendEmail(Buyer a,Person b){
             if(b.canReceive()){
                 b.addTodayReceived();
                 b.ReceiveEmail(a.message);
             }
        }
    }
}
