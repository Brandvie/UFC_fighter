package UFCFighterManagement.filter;

import UFCFighterManagement.dto.FighterDTO;

@FunctionalInterface
public interface FighterFilter {
    boolean test(FighterDTO fighter);
}

