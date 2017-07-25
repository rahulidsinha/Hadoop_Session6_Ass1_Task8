import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TvSales_seq_reducer extends Reducer<Text,IntWritable,Text,IntWritable>{

	public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException
	{
		IntWritable total_sales = new IntWritable();
		int sales = 0;
		
		for (IntWritable value : values)
		{
			sales += value.get();
		}
		total_sales.set(sales);
		context.write(key, total_sales);
	}
}
