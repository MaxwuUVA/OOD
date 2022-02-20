import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class Locker {
    enum LockerSize{
        small,middle,large;
    }
    class User{

    }
    class Package{
        private LockerSize size;
        public Package(LockerSize size){
            this.size = size;
        }
        public LockerSize getSize(){
            return size;
        }
    }
    class LockerSpot{
        private LockerSize size;
        private boolean isEmptyLocker;
        public LockerSpot(LockerSize size){
            this.size = size;
            isEmptyLocker = true;
        }
        public boolean canFitPackage(Package p){
            return p.getSize().equals(size);
        }
        public void putInLocker(Package p){
            if(canFitPackage(p)){
                this.isEmptyLocker = false;
            }
            return;
        }
        public boolean isEmpty(){
            return isEmptyLocker;
        }
    }
    class Lockerslot{
          String Address;
          Map<LockerSize,Deque<LockerSpot>> lockers;
          Map<LockerSize,Deque<LockerSpot>> fullLockers;
          public Lockerslot(){
              //put all the locker in stack;
          }
          public boolean haveSlot(Package p){
              return !lockers.get(p).isEmpty();
          }
          public void findSlotToput(Package p){
              if(haveSlot(p)){
                  LockerSpot newSpot = lockers.get(p.getSize()).pop();
                  newSpot.putInLocker(p);
                  fullLockers.get(p.getSize()).push(newSpot);
              }
              return;
          }
    }
    class LockerServices{
        List<User> userNeedLocker;
        List<Lockerslot> lockerList;
        public Lockerslot closestLocker(User user,List<Lockerslot>lockerList){
             //binary search
        }


    }

}
