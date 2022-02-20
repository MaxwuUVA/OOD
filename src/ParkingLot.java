import java.util.List;

public class ParkingLot{
    enum VehicleSize{
        Large,Small,Motorcycle
    }
    class Vehicle{
        String Id;
        List<ParkingSpot> position;

    }
    class Car{}
    class Bus{}
    class Motorcycle{}
    class ParkingLots{
        List<Level> levels;
        public void park(Vehicle v){
            for(Level l:levels){

            }
        }
    }
    class ticket{
v能拿出部分
    }
    class Level{
        List<ParkingSpot> spots;
        int spotPerrow;
        public Level(int rowNumber,int spotPerRow){
            for(int row = 0;row < rowNumber;row++){
                //number
            }

        }
        public int findAvailable(Vehicle v){
            int spotNeed = v.getNeed();

        }
    }
    class ParkingSpot{
        boolean occupied;
        Vehicle vehicle;
        Level level;

    }
}