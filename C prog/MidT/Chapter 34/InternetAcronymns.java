import java.util.Scanner; // This code coverts some acronymns on the sentence into their phrases

public class InternetAcronymns {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.println("[Acronymn decoder]");
      System.out.print("Enter a line of text w/ acronymns (or type [exit] or [q] to quit): ");
      while (scan.hasNext()) {
         String word = scan.next();
         if (word.equals("exit") || word.equals("q")) {
            System.out.println("Exiting program...");
            break;
         }
         switch (word.toUpperCase()) {         // Replace acronymns with their phrases
            case "OMW":
               System.out.print("On My Way ");
               break;
            case "LMK":
               System.out.print("let Me Know ");
               break;
            case "NVM":
               System.out.print("Never Mind ");
               break; 
            case "U":
               System.out.print("you ");
               break;
            case "LOL":
               System.out.print("Laugh Out Loud ");
               break;
            case "JK":
               System.out.print("Joke ");
               break;
            case "BFF":
               System.out.print("Best Friends Forever ");
               break;
            case "THS": case "THKS": case "TX":
               System.out.print("Thanks ");
               break;
            case "FYI":
               System.out.print("For Your Information ");
               break;
            case "BRB":
               System.out.print("Be Right Back ");
               break;
            case "IDK":
               System.out.print("I Don't Know ");
               break;
            case "IMHO":
               System.out.print("In My Humble Opinion ");
               break;
            case "A.S.A.P.": case "ASAP!": case "ASAP":
               System.out.print("As Soon As Possible ");
               break;
            case "T.G.I.F.":
               System.out.print("Thank God It's Friday ");
               break;
            case "W.T.F.": case "WTF!": case "WTF":
               System.out.print("What The F*** ");
               break;
            case "IIRC":
               System.out.print("If I Remember Correctly ");
               break;
            case "TGIF":
               System.out.print("Thank Goodness It's Friday ");
               break;
            case "DIY":
               System.out.print("Do It Yourself ");
               break;
            case "IRL":
               System.out.print("In Real Life ");
               break;
            case "OMG":
               System.out.print("Oh My God ");
               break;
            case "FYA":
               System.out.print("For Your Action ");
               break;
            case "AFK":
               System.out.print("Away From Keyboard ");
               break;
            case "LMAO":
               System.out.print("Laugh my ass off ");
               break;
            default:
               System.out.print(word + " ");
               break;
         }
      }
        scan.close();
   }
}
