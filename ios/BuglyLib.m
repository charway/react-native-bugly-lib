#import "BuglyLib.h"
#import <Bugly/Bugly.h>

@implementation BuglyLib

RCT_EXPORT_MODULE()

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

+ (BOOL)requiresMainQueueSetup {
    return YES;
}

RCT_EXPORT_METHOD(setUserIdentifier:(NSString *)userId)
{
    [Bugly setUserIdentifier:userId];
}

RCT_EXPORT_METHOD(updateAppVersion:(NSString *)version)
{
    [Bugly updateAppVersion:version];
}

RCT_EXPORT_METHOD(error:(NSString *)message)
{
    [Bugly reportError:message];
}
@end