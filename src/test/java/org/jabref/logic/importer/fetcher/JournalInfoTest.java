package org.jabref.logic.importer.fetcher;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.jabref.model.JournalInfoModel;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

public class JournalInfoTest {

    @Test
    public void journalInfoTest() throws MalformedURLException {
        JournalInfo journalInfo = new JournalInfo("Nature Biomedical Engineering");
        JournalInfoModel journalInfoModel = journalInfo.getJournalFromAPI();

        assertEquals("ok", journalInfoModel.getStatus());
        assertEquals(journalInfoModel.getTitle(), "Nature Biomedical Engineering");
        assertEquals(journalInfoModel.getPublisher(), "Springer Science and Business Media LLC");
        assertEquals(journalInfoModel.getISSN(), "2157-846X");

        journalInfo = new JournalInfo("Nature Biomedical sdsdsdsds");
        journalInfoModel = journalInfo.getJournalFromAPI();

        assertEquals("ok", journalInfoModel.getStatus());
        assertEquals(journalInfoModel.getTitle(), "");
        assertEquals(journalInfoModel.getPublisher(), "");
        assertEquals(journalInfoModel.getISSN(), "");
    }


}
