package UFCFighterManagement.filter;

public class FighterFilters {
    // Filter by minimum age
    public static FighterFilter ageAtLeast(int minAge) {
        return fighter -> fighter.getAge() >= minAge;
    }

    // Filter by weight class
    public static FighterFilter weightClassEquals(String weightClass) {
        return fighter -> fighter.getWeightClass() != null && fighter.getWeightClass().equalsIgnoreCase(weightClass);
    }

    // Filter by stance
    public static FighterFilter stanceEquals(String stance) {
        return fighter -> fighter.getStance() != null && fighter.getStance().equalsIgnoreCase(stance);
    }

    // Filter by coach
    public static FighterFilter coachEquals(String coach) {
        return fighter -> fighter.getCoach() != null && fighter.getCoach().equalsIgnoreCase(coach);
    }

    // Filter by reach range
    public static FighterFilter reachBetween(double min, double max) {
        return fighter -> fighter.getReach() >= min && fighter.getReach() <= max;
    }

    // Filter by promotion
    public static FighterFilter promotionEquals(String promotion) {
        return fighter -> fighter.getPromotion() != null && fighter.getPromotion().equalsIgnoreCase(promotion);
    }

    // Filter by wins (from record string like "20-3-0")
    public static FighterFilter winsAtLeast(int minWins) {
        return fighter -> {
            if (fighter.getRecord() == null) return false;
            String[] parts = fighter.getRecord().split("-");
            if (parts.length >= 1) {
                try {
                    int wins = Integer.parseInt(parts[0]);
                    return wins >= minWins;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            return false;
        };
    }

    // Combine multiple filters
    public static FighterFilter and(FighterFilter... filters) {
        return fighter -> {
            for (FighterFilter filter : filters) {
                if (!filter.test(fighter)) return false;
            }
            return true;
        };
    }
}

