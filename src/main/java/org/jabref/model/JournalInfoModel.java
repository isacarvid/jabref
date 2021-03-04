package org.jabref.model;

import com.google.gson.annotations.SerializedName;
import javafx.util.Pair;

import java.util.*;

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
        if(message == null) return "";
        return message.getItems().length == 0? "" : message.items[0].getTitle();
    }


    public ArrayList<Pair<Integer, Integer>> getDoisPerYears() {
        ArrayList<Pair<Integer, Integer>> doisPerYears = new ArrayList<>();
        if(message == null){ return doisPerYears;}
        ArrayList<ArrayList<Integer>> yearsAndDois = this.message.items[0].getBreakdowns().getDoisIssuedByYear();
        for(int i = 0; i < yearsAndDois.size(); i++){
            doisPerYears.add(new Pair<>(yearsAndDois.get(i).get(0),  yearsAndDois.get(i).get(1)));
        }

        Collections.sort(doisPerYears, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(final Pair<Integer, Integer> o1, final Pair<Integer, Integer> o2) {
                int i = o1.getKey() - o2.getKey();
                return i;
            }
        });
        return doisPerYears;
    }

    public String getISSN() {
        if(message == null) return "";
        return message.getItems().length == 0? "" : message.items[0].getISSN()[0];
    }


    public String getPublisher() {
        if(message == null) return "";
        return message.getItems().length == 0 ? "" : message.items[0].getPublisher();
    }


    public JournalInfoModel(){

    }



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
            private Breakdowns breakdowns;

            public Breakdowns getBreakdowns() {
                return breakdowns;
            }

            public void setBreakdowns(Breakdowns breakdowns) {
                this.breakdowns = breakdowns;
            }


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

            private class Breakdowns {

                public ArrayList<ArrayList<Integer>> getDoisIssuedByYear() {
                    return doisIssuedByYear;
                }

                public void setDoisIssuedByYear(ArrayList<ArrayList<Integer>> doisIssuedByYear) {
                    this.doisIssuedByYear = doisIssuedByYear;
                }

                @SerializedName(value = "dois-by-issued-year", alternate = "dois-issued-by-year")
                private ArrayList<ArrayList<Integer>> doisIssuedByYear;


                }
            }
        }
    }



