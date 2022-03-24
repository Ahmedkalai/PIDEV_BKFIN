package com.BKFIN.config;
import com.BKFIN.entities.unemployedpopulation;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.FileSystemResource;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfigKhadija {
		
   @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<unemployedpopulation> itemReader,
                  ItemProcessor<unemployedpopulation, unemployedpopulation> itemProcessor,
                   ItemWriter<unemployedpopulation> itemWriter
    ) {

        Step step = stepBuilderFactory.get("ETL-file-load")
              .<unemployedpopulation, unemployedpopulation>chunk(100)
               .reader(itemReader)
               .processor(itemProcessor)
                .writer(itemWriter)
                .build();


        return (Job) jobBuilderFactory.get("ETL-Load")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }
   
   
   public ConversionService createConversionService() {
       DefaultConversionService conversionService = new DefaultConversionService();
       DefaultConversionService.addDefaultConverters(conversionService);
       conversionService.addConverter(new Converter<String, LocalDate>() {
           @Override
           public LocalDate convert(String text) {
               DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
               return LocalDate.parse(text, formatter);
           }
       });
       return conversionService;
   }
   
    @Bean
    public FlatFileItemReader<unemployedpopulation> itemReader() {

        FlatFileItemReader<unemployedpopulation> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new FileSystemResource("src/main/resources/unemployedpopulation.csv"));
        flatFileItemReader.setName("CSV-Reader");
       flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(lineMapper());
        return flatFileItemReader;
    }

    @Bean
    public LineMapper<unemployedpopulation> lineMapper() {

        DefaultLineMapper<unemployedpopulation> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("Population_id", "Regions", "environment", "Sexe",
        		"Distribution_of_population","number_houses","less_than_1Km","Between_1KM_2Km",
        		"Plus2Km","Population_aged_15_and_plus","active_Population_Occupied","Inactive_Population",
        		"activity_rate","Unemployment_rate","Unemployed_Néant",
        		"Unemployed_Primary","Unemployed_Secondary","Unemployed_faculty","Unemployed_Agriculture_fishing",
        		"Unemployed_Mines_energy","Unemployed_manufacturing_Industry","Unemployed_Building_public_works",
        		"Unemployed_Commerce","Unemployed_Transport","Unemployed_Education_health_administrative_services",
        		"Unemployed_Other_services","Unemployed_Undeclared","Unemployed_15_19_years_Age",
        		"Unemployed_20_24_years_Age","Unemployed_25_29_years_Age","Unemployed_30_34_years_Age",
        		"Unemployed_35_39_years_Age","Unemployed_40_44_years_Age","Unemployed_45_49_years_Age",
        		"Unemployed_50_59_years_Age","Unemployed_60plus_years");

        BeanWrapperFieldSetMapper<unemployedpopulation> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(unemployedpopulation.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;
    }

}