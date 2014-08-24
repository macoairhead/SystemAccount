package test.java;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.ParameterConverters.DateConverter;
import org.jbehave.core.steps.ParameterConverters.ExamplesTableConverter;
import org.junit.runner.RunWith;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class S2InfoStories extends JUnitStories {
	private final CrossReference xref = new CrossReference();

	public S2InfoStories() {
		configuredEmbedder().embedderControls()
				.doGenerateViewAfterStories(true)
				.doIgnoreFailureInStories(true).doIgnoreFailureInView(true)
				.useThreads(1).useStoryTimeoutInSecs(60);
	}

	@Override
	public Configuration configuration() {
		Class<? extends Embeddable> embeddableClass = this.getClass();
		Properties viewResources = new Properties();
		viewResources.put("decorateNonHtml", "true");
		// Start from default ParameterConverters instance
		ParameterConverters parameterConverters = new ParameterConverters();
		// factory to allow parameter conversion and loading from external
		// resources (used by StoryParser too)
		ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(
				new LocalizedKeywords(),
				new LoadFromClasspath(embeddableClass), parameterConverters);
		// add custom converters
		parameterConverters.addConverters(new DateConverter(
				new SimpleDateFormat("yyyy-MM-dd")),
				new ExamplesTableConverter(examplesTableFactory));
		return new MostUsefulConfiguration()
				.useStoryControls(
						new StoryControls().doDryRun(false)
								.doSkipScenariosAfterFailure(false))
				.useStoryLoader(new LoadFromClasspath(embeddableClass))
				.useStoryParser(new RegexStoryParser(examplesTableFactory))
				.useStoryReporterBuilder(
						new StoryReporterBuilder()
								.withCodeLocation(
										CodeLocations
												.codeLocationFromClass(embeddableClass))
								.withDefaultFormats()
								.withViewResources(viewResources)
								.withFormats(Format.CONSOLE, Format.TXT,
										Format.HTML, Format.XML)
								.withFailureTrace(true)
								.withFailureTraceCompression(true)
								.withCrossReference(xref))
				.useParameterConverters(parameterConverters)
				.useStepMonitor(xref.getStepMonitor());

	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new InfoSteps());
	}

	@Override
	protected List storyPaths() {
		return Arrays.asList("test/resources/Info.story");
	}
}
