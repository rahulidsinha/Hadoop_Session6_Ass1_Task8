import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Task8_mapper extends Mapper<Text,IntWritable,IntWritable,Text> {
	public void map(Text key, IntWritable value, Context context) throws IOException, InterruptedException
	{
		System.out.println("After switching, Key : "+value.toString()+"\tValue : "+key.toString());
		// We will switch the key value as the sorting will take place on 
		// value i.e. no of units sold
		context.write(value,key);
	}

}
