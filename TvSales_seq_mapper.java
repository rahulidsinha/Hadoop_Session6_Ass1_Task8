import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TvSales_seq_mapper extends Mapper<LongWritable,Text,Text,IntWritable>{
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	{
		Text company_name = new Text();
		IntWritable one = new IntWritable(1);
		
		String temp = value.toString();
		
		if(!(temp.contains("|NA")   || 
		   temp.contains("|NA|" ) || 
		   temp.contains("NA|")))
		{
			String[] splits = temp.split("\\|");	
			company_name.set(splits[0]);
			context.write(company_name, one);
		}
		
	}
}
