һ������׼�� 
  1��׼����̨rabbitmq��������һ̨�����й���һ̨��������
  2��ÿ̨rabbitmq����װ��shovel plunin��shovel management plunin
  3��ÿ̨rabbitmq���½���winit_send,winit_receive����exchange,���У�
      winit_send���ڷ�����Ϣ��Typeָ��Ϊtopic��durableָ��Ϊtrue
      winit_receive���ڽ�����Ϣ��Typeָ��Ϊheaders��durableָ��Ϊtrue
  4��������������exchange�İ󶨹�ϵ
    �й�rabbitmq:
    ��winit_send���exchange,ʹ��#.CN���bind routing key������winit_receive�İ󶨹�ϵ
    ����rabbitmq:
    ��winit_send���exchange,ʹ��#.US���bind routing key������winit_receive�İ󶨹�ϵ
  5)����shovel��ϵ
    �й�rabbitmq:
    Name��US_TO_CN,
    Source: amqp//�û���:����@����������ip:�˿�/��ѡ��Exchange������winit_send,routing key����#.CN
    Destination: amqp//�û���:����@�й�������ip:�˿�/��ѡ��Exchange������winit_receive,routing key������
    ����rabbitmq:
    Name��CN_TO_US,
    Source: amqp//�û���:����@�й�������ip:�˿�/��ѡ��Exchange������winit_send,routing key����#.US
    Destination: amqp//�û���:����@����������ip:�˿�/��ѡ��Exchange������winit_receive,routing key������
    
����������Ϣ���ճ���
  ��װjdk 7,��receiverĿ¼��������Ҫ�޸�config.properties��Ȼ��ʹ��java -jar receiver.jar�������ճ���
����������Ϣ���ͳ���
  ��װjdk 7,��senderĿ¼��������Ҫ�޸�config.properties��Ȼ��ʹ��java -jar sender.jar�������ͳ���