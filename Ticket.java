package Usecase;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;


		public class Ticket {
			private int count;
			private String pnr;
			private LocalDate TravelDate;
			private Train train;
			private Passenger Passenger;
			
			
			
			
			public Ticket(LocalDate travelDate, Train train) {
				super();
				TravelDate = travelDate;
				this.train = train;
			}




			public int getCount() {
				return count;
			}




			public void setCount(int count) {
				this.count = count;
			}




			public String getPnr() {
				return pnr;
			}




			public void setPnr(String pnr) {
				this.pnr = pnr;
			}




			public LocalDate getTravelDate() {
				return TravelDate;
			}




			public void setTravelDate(LocalDate travelDate) {
				TravelDate = travelDate;
			}




			public Train getTrain() {
				return train;
			}




			public void setTrain(Train train) {
				this.train = train;
			}
			
			


		@Override
			public String toString() {
				return "Ticket [count=" + count + ", pnr=" + pnr + ", TravelDate=" + TravelDate + ", train=" + train
						+ ", Passenger=" + Passenger + "]";
			}




		public String generatePNR()
		{
			String S=String.valueOf(train.getSource().charAt(0));
			String D=String.valueOf(train.getDestination().charAt(0));
			String date=TravelDate.format(DateTimeFormatter.ofPattern("YYYYMMDD"));
			String pnr=S+D+""+date+""+count++;
			
			if(TravelDate.isAfter(LocalDate.now()))
			{
				return pnr;
			}
			else
			{
				return "please enter valid date";

				
			}
		}
					
				
		// calculate passenger fare
			double calPassengerFare(Passenger Passenger)
			{
				
				if(Passenger.getAge()<=12)
					return 0.5*(train.getTicketPrice());
			
			else if(Passenger.getAge()>=60)
				return 0.6*(train.getTicketPrice());
			
			else if(Passenger.getGender()=='F')
				return 2.5*(train.getTicketPrice());
			else
				return train.getTicketPrice();
			}

			
			//add passenger
			public void addPassenger(String name,int age,char gender)throws NullPointerException
			{
				Passenger=new TreeMap();
				Integer fare=(int)calPassengerFare(new Passenger(name,age,gender));
				Passenger.put(new Passenger(name,age,gender), fare);	
			}
			
			
			//calculate total ticket price
			double calculateTotalTicketPrice()
			{
				int totalPrice=0;
				Collection<Integer> price=((SortedMap) Passenger).values();
				for(Integer values:price)
				{
					totalPrice=totalPrice+values;
				}
				return (double)totalPrice;
			}
			
			//generate ticket
			StringBuilder generateTicket()
			{
				StringBuilder sb=new StringBuilder();
				sb.append("PNR    :"+generatePNR()).append("travelDate  :"+TravelDate).append("trainNo :"+train.getTrainNo()).append("trainName  :"+train.getTrainName()).append("Source  :"+train.getSource()).append("destination   :"+train.getDestination());
			    return sb;
			}



		//getter setter
			public Passenger getPassenger() {
				return Passenger;
			}

			public void setPassenger(Passenger passenger2) {
				Passenger = passenger2;
	
	}

}
