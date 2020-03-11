package blast;

/**
* Sequential Version of BLAST -
*
* @author Alexander Dean
**/

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import pjbio.*;

public class BlastController {
	
	public BlastController(){
		
	}

    public String blastQuery(char queryType, String dbFile, String dbIndx, 
    		                 float prct, String qSeq) throws Exception{
         
        AlignmentPrinter out;
        ProteinDatabase pd = new ProteinDatabase( new File( dbFile ) , new File(dbIndx) );
        float percentage = prct;
        StringBuilder output = new StringBuilder(); // jmap
        
        Sequence query;
        BLAST aligner;
        if(queryType == 'p'){
            query = new ProteinSequence(">Search Query", qSeq);
            aligner = new BLASTP(pd.getProteinCount());
        }else{ //queryType == 'n'
            query = new NucleotideSequence(">Search Query", qSeq);
            aligner = new BLASTN(pd.getProteinCount());
        }
        
        long t1 = System.currentTimeMillis();
        for(long i=0; i < pd.getProteinCount()*percentage; i++){
         Alignment[] tmp = aligner.align( query, pd.getProteinSequence( i ) );
         // Print the alignments
            for(int j=0; j<tmp.length;j++){
            	ByteArrayOutputStream os = new ByteArrayOutputStream();
            	PrintStream ps = new PrintStream(os);
             out = new AlignmentPrinter(ps,new DefaultAlignmentStats(tmp[j].getSubjectLength()));
             out.printDetails(tmp[j], query, pd.getProteinSequence(i));
         	String partial_output = os.toString("UTF8");
         	output.append(partial_output);
            }
        }
        long t2 = System.currentTimeMillis();

        output.append("\n\nRunning Time: ");
        output.append(Long.toString(t2-t1));
        output.append(" msec\n");
        
        return output.toString();
    }


}