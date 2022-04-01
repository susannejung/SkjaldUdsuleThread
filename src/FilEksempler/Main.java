package FilEksempler;


class Skjald extends Thread{

    private String[] strofer;
    int forsinkelse;
    int gentagelser;

    public Skjald(String[] strofer, int forsinkelse, int gentagelser){
        super();
        this.strofer = strofer;
        this.forsinkelse = forsinkelse;
        this.gentagelser = gentagelser;
    }

    // udskriver ét vers ad gangen med forsinkelse efter verset
    private void syngVers(){
        StringBuffer str = new StringBuffer(100);
        for(int i = 0; i < strofer.length; i++){
            str.append(strofer[i] + "\n");
        }
        System.out.println(str.toString());
        try{
            if (forsinkelse > 0) Thread.sleep(forsinkelse);
        }
        catch (InterruptedException e)
        {}
    }

    public void run(){
        for(int g = 1; g <= gentagelser; g++){
            syngVers();
        }
    }
} // end class Skjald

class Sangkor2{

    private static String[] mesterJakob =
            {"MESTER JAKOB, MESTER JAKOB", "SOVER DU, SOVER DU",
                    "HØRER DU EJ KLOKKEN, HØRER DU EJ KLOKKEN",
                    "BIM BAM BUM, BIM BAM BUM"};

    private static String[] gladeJul =
            {"Glade jul, dejlige jul", "Engle daler ned i skjul!",
                    "Hid de flyver med paradisgrønt", "Hvor de ser, hvad for Gud er kønt",
                    "Lønligt iblandt os de går", "Lønligt iblandt os de går"};

    public static void main(String[] args){
        Skjald skjald1 = new Skjald(mesterJakob,0,3);
        Skjald skjald2 = new Skjald(gladeJul,0,3);

        skjald1.setPriority(Thread.NORM_PRIORITY);
        skjald2.setPriority(Thread.NORM_PRIORITY+1);

        skjald1.start();
        skjald2.start();


    }
} // end class Sangkor2

