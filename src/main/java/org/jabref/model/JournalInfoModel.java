package org.jabref.model;

public class JournalInfoModel {
    private Message message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
    public String getTitle() {
        return message.getItems().length == 0? "" : message.items[0].getTitle();
    }

    public String getISSN() {
        return message.getItems().length == 0? "" : message.items[0].getISSN()[0];
    }


    public String getPublisher() {
        return message.getItems().length == 0? "" : message.items[0].getPublisher();
    }


    public JournalInfoModel(){}



    private class Message {
        private Item[] items;

        public Item[] getItems() {
            return items;
        }

        public void setItems(Item[] items) {
            this.items = items;
        }
        private class Item {
            private String title = "";
            private String[] ISSN = {""};
            private String publisher = "";

            public Item(){}

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String[] getISSN() {
                return ISSN;
            }

            public void setISSN(String[] ISSN) {
                this.ISSN = ISSN;
            }

            public String getPublisher() {
                return publisher;
            }

            public void setPublisher(String publisher) {
                this.publisher = publisher;
            }
        }
    }


}
