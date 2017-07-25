import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Task8_reducer extends Reducer<IntWritable,Text,Text,IntWritable>{
	public void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException
	{
		
		for(Text value : values)
		{
			context.write(value, key);
		}
	}
}
