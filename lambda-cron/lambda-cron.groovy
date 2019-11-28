@Grab('software.amazon.awscdk:core:1.18.0')
@Grab('software.amazon.awscdk:events:1.18.0')
@Grab('software.amazon.awscdk:events-targets:1.18.0')
@Grab('software.amazon.awscdk:lambda:1.18.0')

import software.amazon.awscdk.core.*
import software.amazon.awscdk.services.events.*
import software.amazon.awscdk.services.events.targets.*
import software.amazon.awscdk.services.lambda.*

class LambdaCronStack extends Stack {
  LambdaCronStack(final Construct parent, final String name) {
    super(parent, name)

    final lambdaFunction = SingletonFunction.Builder.create(this, "cdk-lambda-cron")
      .description("Lambda which prints \"I'm running\"")
      .code(Code.fromInline('''
      def main(event, context):
          print("I'm running!")
      '''))
      .handler("index.main")
      .timeout(Duration.seconds(300))
      .runtime(Runtime.PYTHON_3_7)
      .uuid(UUID.randomUUID().toString())
      .build()

    final rule = Rule.Builder.create(this, "cdk-lambda-cron-rule")
      .description("Run every day at 6PM UTC")
      .schedule(Schedule.expression("cron(0 18 ? * MON-FRI *)"))
      .build()

    rule.addTarget(new LambdaFunction(lambdaFunction))
  }
}

App app = new App()
new LambdaCronStack(app, "cdk-lambda-cron-example")
app.synth()