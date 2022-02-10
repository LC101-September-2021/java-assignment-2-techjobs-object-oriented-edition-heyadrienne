package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Before
    public void createJobObject() {
        Job job1 = new Job();
        Job job2 = new Job();
    }

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertEquals(job1.getId() + 1, job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob instanceof Job);
        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(testJob.getName(), "Product tester");
        assertEquals(testJob.getEmployer().toString(), "ACME");
        assertEquals(testJob.getLocation().toString(), "Desert");
        assertEquals(testJob.getPositionType().toString(), "Quality control");
        assertEquals(testJob.getCoreCompetency().toString(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char firstLine = testJob1.toString().charAt(0);
        char lastLine = testJob1.toString().charAt(testJob1.toString().length() - 1);
        assertEquals(firstLine, '\n');
        assertEquals(lastLine, '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\n" + "ID: " + testJob1.getId() + "\n" + "Name: Product tester" + "\n" + "Employer: ACME" + "\n" + "Location: Desert" + "\n" + "Position Type: Quality control" + "\n" + "Core Competency: Persistence" + "\n", testJob1.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job testJob1 = new Job("Product tester", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals("\n" + "ID: " + testJob1.getId() + "\n" + "Name: Product tester" + "\n" + "Employer: Data not available" + "\n" + "Location: Data not available" + "\n" + "Position Type: Data not available" + "\n" + "Core Competency: Data not available" + "\n", testJob1.toString());
    }




}
