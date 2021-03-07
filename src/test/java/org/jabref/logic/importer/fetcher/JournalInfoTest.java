package org.jabref.logic.importer.fetcher;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.jabref.model.JournalInfoModel;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

public class JournalInfoTest {

    /**
     * Test api request were only some information is available
     */
    @Test
    public void testPartialResponse() throws MalformedURLException {
        JournalInfo journalInfo = new JournalInfo("A General Approach to Panel Data Set-Theoretic Research");
        JournalInfoModel journalInfoModel = journalInfo.getJournalFromAPI();

        assertEquals("ok", journalInfoModel.getStatus());
        assertEquals(journalInfoModel.getTitle(), "A General Approach to Panel Data Set-Theoretic Research");
        assertEquals(journalInfoModel.getPublisher(), "Cairo Center for Development Benchmarking");
        assertEquals(journalInfoModel.getISSN(), "");

    }

    /**
     * Test api request were journal does not exist
     */
    @Test
    public void testInvalidJournal() throws MalformedURLException {
        JournalInfo journalInfo = new JournalInfo("Nature Biomedical sdsdsdsds");
        JournalInfoModel journalInfoModel = journalInfo.getJournalFromAPI();

        assertEquals("ok", journalInfoModel.getStatus());
        assertEquals(journalInfoModel.getTitle(), "");
        assertEquals(journalInfoModel.getPublisher(), "");
        assertEquals(journalInfoModel.getISSN(), "");
    }
    /**
     * Test api request were journal field is empty
     */
    @Test
    public void testEmptyJournal() throws MalformedURLException {
        JournalInfo journalInfo = new JournalInfo("");
        JournalInfoModel journalInfoModel = journalInfo.getJournalFromAPI();

        assertEquals("ok", journalInfoModel.getStatus());
        assertEquals(journalInfoModel.getTitle(), "");
        assertEquals(journalInfoModel.getPublisher(), "");
        assertEquals(journalInfoModel.getISSN(), "");
    }

    /**
     * Test api request were Multiple dois per year are available
     */
    @Test
    public void testMultipleDois() throws MalformedURLException {
        JournalInfo journalInfo = new JournalInfo("Nature Biomedical Engineering");
        JournalInfoModel journalInfoModel = journalInfo.getJournalFromAPI();
        assertEquals("ok", journalInfoModel.getStatus());
        assertEquals(journalInfoModel.getTitle(), "Nature Biomedical Engineering");
        assertEquals(journalInfoModel.getPublisher(), "Springer Science and Business Media LLC");
        assertEquals(journalInfoModel.getISSN(), "2157-846X");
        assertEquals(6, journalInfoModel.getDoisPerYears().get(0).getValue());
        assertEquals(157, journalInfoModel.getDoisPerYears().get(1).getValue());

    }

}
