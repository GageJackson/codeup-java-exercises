public class ServerNameGenerator {
    String [] prefix = {"Cyber", "Neo", "Hyper", "Quantum", "Digital", "Future", "Robo", "Mega", "Space", "Cosmic"};
    String [] suffix = {"Tech", "Logic", "Core", "Hive", "Engine", "Matrix", "Hub", "Sphere", "Cloud", "Verse"};


    public static void main(String[] args) {
        ServerNameGenerator name = new ServerNameGenerator();
        String randPrefix = name.getPrefix();
        String randSuffix = name.getSuffix();
        System.out.println("Here is your server name: ");
        System.out.println(randPrefix + "-" +randSuffix);
    }

    public String getPrefix(){
        int rand = (int) Math.floor(Math.random() * 10);
        return prefix[rand];
    }

    public String getSuffix(){
        int rand = (int) Math.floor(Math.random() * 10);
        return suffix[rand];
    }
}
