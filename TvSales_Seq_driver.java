import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;



public class TvSales_Seq_driver {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		Configuration conf = new Configuration();
		
		Job job = Job.getInstance(conf, " TVSales with output as Sequence fileformat");
		
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(SequenceFileOutputFormat.class);
		
		job.setJarByClass(TvSales_Seq_driver.class);
		job.setMapperClass(TvSales_seq_mapper.class);
		job.setReducerClass(TvSales_seq_reducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		System.exit(job.waitForCompletion(true)? 0: -1);
		

	}

}
