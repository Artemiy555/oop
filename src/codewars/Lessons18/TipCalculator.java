package codewars.Lessons18;

public class TipCalculator {
    public static double calculateTip(double amount, String rating) {
        switch (rating){
            case "Terrible": return 0;
            case "Poor": return amount/0.05;
            case "Good": return amount/0.12;
            case "Great": return amount/0.15;
            case "Excellent": return amount/0.2;
            default: return 0;
        }
    }
}
