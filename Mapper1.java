import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
 
public static class Mapper1 extends Mapper<Object, Text, Text, LongWritable> 
       {
		private Text word = new Text();
		private static LongWritable one = new LongWritable(1);
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException 
               {
			StringTokenizer itr = new StringTokenizer(value.toString());
			while (itr.hasMoreTokens()) 
                        {		
		        String s = itr.nextToken();  
	                long val = Long.parseLong(s);
	                one.set(val);context.write(word, one);
			}			
		}
	}
 
 
	