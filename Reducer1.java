import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public static class Reducer1 extends Reducer<Text, LongWritable, Text, LongWritable> 
           {
			private LongWritable result = new LongWritable();
			private Text m1 = new Text("Sum");
			public void reduce(Text key, Iterable<LongWritable> values,Context context) throws IOException, InterruptedException
                       {
				long sum=0;
				for (LongWritable val : values) 
                                {
					int a=2;
					long b=val.get();
					while(a<b)
                                       {
						if(b%a==0)
							break;
						a++;
					}
					if(a==b)
                                        {
					    sum=sum+b;
					}					
				}
				result.set(sum);
				context.write(m1, result);
			}
		}