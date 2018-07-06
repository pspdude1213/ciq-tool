import java.util.Scanner;

class CIQ {
    private String CIQName;
    private String IPAddress;
    private String nodeType;
    private int CIQNumConnections;
    private int CIQNumPeers;
    private int typeID;

    public CIQ (String name, String addr, String type, int conn, int peers) {
    	this.CIQName = name;
	this.IPAddress = addr;
	this.nodeType = type;
    	this.CIQNumConnections = conn;	
    	this.CIQNumPeers = peers;
	this.typeID = 0;
    }
    
    public String toString(){
	return "Name: " + this.getCIQName() + 
	       "\nIP Address: " + this.getIPAddress() +
	       "\nNode Type: " + this.getNodeType() + "\n";
    }

    private int findTemplate(String str){
	String temp = str.toUpperCase();
	
	switch(temp){
	    case "PGW"  : this.typeID=1; break;
	    case "MME"  : this.typeID=2; break;
	    case "AAA"  : this.typeID=3; break;
	    case "PCRF" : this.typeID=4; break; 
	    default     : this.typeID=-1; System.out.println("Invalid Node Type!"); break;
	}
        return this.typeID;
    }

    private int updateTemplate(int template){
	switch(template){
	    case 1 : System.out.println("Loading PGW Temaplate..."); break;
	    case 2 : System.out.println("Loading MME Temaplate..."); break;
	    case 3 : System.out.println("Loading AAA Temaplate..."); break;
	    case 4 : System.out.println("Loading PCRF Temaplate..."); break; 
	    default     : System.out.println("Temaplate not Found...");return -1;
	}
	return 0;
    }

    private int fillCIQ(){
	return 0;
    }

    // GETs 
    public String getCIQName(){
	return CIQName;
    }
    public String getIPAddress(){
	return IPAddress;
    }
    public String getNodeType(){
	return this.nodeType;
    }
    public int getCIQNumConnections(){
	return this.CIQNumConnections;
    }
    public int getCIQNumPeers(){
	return this.CIQNumPeers;
    }
    public int getTypeID(){
	return this.typeID;
    }

    // SETs 
    public int setCIQName(String name){
	this.CIQName = name.toUpperCase();
	return 0;
    }
    public int setIPAddress(String IP){
	this.IPAddress = IP;
	return 0;
    }
    public int setNodeType(String type){
	this.nodeType=type.toUpperCase();
	return 0;
    }
    public int setCIQNumConnections(int num){
	this.CIQNumConnections = num;
	return 0;
    }
    public int setCIQNumPeers(int num){
	this.CIQNumPeers = num;
	return 0;
    }
    public int setTypeID(int num){
	this.typeID = num;
	return 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter node name: ");
	String name = scan.nextLine();
	
        System.out.print("Enter IP Address: ");
	String addr = scan.nextLine();
	
	System.out.print("Enter Node Type: ");
	String type = scan.nextLine();

        System.out.print("Enter number of connections: ");
        int num_conns = scan.nextInt();
        
        System.out.print("Enter number of peers: ");
        int num_peers = scan.nextInt();

        CIQ DRA_CIQ = new CIQ(name, addr, type, num_conns, num_peers);

        System.out.println("\nCIQ Parameters\n"+DRA_CIQ);
	
	int templateNum = DRA_CIQ.findTemplate(DRA_CIQ.getNodeType());
	DRA_CIQ.updateTemplate(templateNum);
	DRA_CIQ.fillCIQ();

        scan.close();
    }
}
