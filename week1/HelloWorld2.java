public class HelloWorld2 {
// I USED CHAT GPT FOR ASSISTANCE (i feel i understand it a little bit. but chat gpt explained it a bit)
    public static void main(String[] args) {
        // Check if a name is provided as a command line argument
        if (args.length > 0) {
            
            
            // Print additional system properties
            System.out.println("\nSystem Properties:");
            // Print Java class path
            System.out.println("Java Class Path: " + System.getProperty("java.class.path"));
            // Print Java home directory
            System.out.println("Java Home: " + System.getProperty("java.home"));
            // Print Java version
            System.out.println("Java Version: " + System.getProperty("java.version"));
            // Print operating system architecture
            System.out.println("OS Architecture: " + System.getProperty("os.arch"));
            // Print operating system version
            System.out.println("OS Version: " + System.getProperty("os.version"));
            // Print current working directory
            System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
            // Print user home directory
            System.out.println("User Home Directory: " + System.getProperty("user.home"));
            // Print user account name
            System.out.println("User Account Name: " + System.getProperty("user.name"));
            // Print personalized greeting using command line arguments
            System.out.println("Hello " + concatenateArgs(args) + ". Nice work processing the arguments!");

        } else {
            // Print a message if no name is provided as a command line argument
            System.out.println("Please provide your name as a command line argument.");
        }
    }

    // Helper method to concatenate command line arguments into a single string
    private static String concatenateArgs(String[] args) {
        StringBuilder result = new StringBuilder();
        for (String arg : args) {
            result.append(arg).append(" ");
        }
        return result.toString().trim();
    }
}
