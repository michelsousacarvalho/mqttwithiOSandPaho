//
//  ViewController.m
//  MqttExample
//
//  Created by Michel de Sousa Carvalho on 05/02/15.
//  Copyright (c) 2015 Michel de Sousa Carvalho. All rights reserved.
//

#import "ViewController.h"
#import "MQTTKit.h"
#define MQTTBroker @"iot.eclipse.org"
#define TOPIC @"test/mqttAndiOS"

@interface ViewController ()

@property (nonatomic, strong) MQTTClient *client;
@property (weak, nonatomic)  IBOutlet UILabel *label;


@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    NSString *clientID = [UIDevice currentDevice].identifierForVendor.UUIDString;
    self.client = [[MQTTClient alloc] initWithClientId:clientID];
    self.client.port = 1883;
//    __weak ViewController *self_ = self;
//    self.label.text = @"OLA";
    
    [self.client setMessageHandler:^(MQTTMessage *message) {
        NSString *text = message.payloadString;
        NSLog(@"received message %@", text);
        dispatch_async(dispatch_get_main_queue(), ^{
                [self.label setText:text];
        });
        
    }];

    
    
    [self.client connectToHost:MQTTBroker completionHandler:^(MQTTConnectionReturnCode code) {
        if (code == ConnectionAccepted) {
            // The client is connected when this completion handler is called
            NSLog(@"client is connected with id %@", clientID);
            // Subscribe to the topic
            [self.client subscribe:TOPIC withCompletionHandler:^(NSArray *grantedQos) {
                // The client is effectively subscribed to the topic when this completion handler is called
            }];
        }
    }];

    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
