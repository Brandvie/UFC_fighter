package UFCFighterManagement;

import UFCFighterManagement.dto.FighterDTO;
import UFCFighterManagement.filter.FighterFilters;
import UFCFighterManagement.util.JsonConverter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UFCFighterManagementAppTest {

    @Test
    public void testFighterDTOCreation() {
        FighterDTO fighter = new FighterDTO(1, "Jon Jones", 36, "Heavyweight", "27-1-0", "Orthodox", 84.5, "Greg Jackson", "UFC");
        
        assertEquals(1, fighter.getId());
        assertEquals("Jon Jones", fighter.getName());
        assertEquals(36, fighter.getAge());
        assertEquals("Heavyweight", fighter.getWeightClass());
        assertEquals("27-1-0", fighter.getRecord());
        assertEquals("Orthodox", fighter.getStance());
        assertEquals(84.5, fighter.getReach());
        assertEquals("Greg Jackson", fighter.getCoach());
        assertEquals("UFC", fighter.getPromotion());
    }

    @Test
    public void testFighterToJson() {
        FighterDTO fighter = new FighterDTO(1, "Jon Jones", 36, "Heavyweight", "27-1-0", "Orthodox", 84.5, "Greg Jackson", "UFC");
        String json = JsonConverter.fighterToJson(fighter);
        
        assertTrue(json.contains("\"name\":\"Jon Jones\""));
        assertTrue(json.contains("\"weightClass\":\"Heavyweight\""));
        assertTrue(json.contains("\"record\":\"27-1-0\""));
    }

    @Test
    public void testFighterFilters() {
        FighterDTO fighter1 = new FighterDTO(1, "Jon Jones", 36, "Heavyweight", "27-1-0", "Orthodox", 84.5, "Greg Jackson", "UFC");
        FighterDTO fighter2 = new FighterDTO(2, "Islam Makhachev", 32, "Lightweight", "25-1-0", "Orthodox", 70.0, "Abdulmanap Nurmagomedov", "UFC");
        
        List<FighterDTO> fighters = Arrays.asList(fighter1, fighter2);
        
        // Test age filter
        assertTrue(FighterFilters.ageAtLeast(35).test(fighter1));
        assertFalse(FighterFilters.ageAtLeast(35).test(fighter2));
        
        // Test weight class filter
        assertTrue(FighterFilters.weightClassEquals("Heavyweight").test(fighter1));
        assertFalse(FighterFilters.weightClassEquals("Heavyweight").test(fighter2));
        
        // Test wins filter
        assertTrue(FighterFilters.winsAtLeast(25).test(fighter1));
        assertTrue(FighterFilters.winsAtLeast(25).test(fighter2));
    }

    @Test
    public void testDefaultPromotion() {
        FighterDTO fighter = new FighterDTO();
        assertEquals("UFC", fighter.getPromotion());
    }
}

