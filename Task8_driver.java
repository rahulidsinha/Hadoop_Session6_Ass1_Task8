import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


public class Task8_driver {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		Configuration conf = new Configuration();
		Job job =Job.getInstance(conf, "Sort by Tv Sales");
		
		job.setJarByClass(Task8_driver.class);
		job.setMapperClass(Task8_mapper.class);
		job.setReducerClass(Task8_reducer.class);
		
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		job.setInputFormatClass(SequenceFileInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		System.exit(job.waitForCompletion(true) ? 0 :-1);

	}

}
