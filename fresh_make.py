# -*- coding: utf-8 -*-

import re
import uuid
import random
import datetime

vdestination_arr = ['成都', '上海', '西安', '重庆', '长春']
vitemId_arr = ['06A99B35601349AB930EDAB7EE808F19',
               '0DC2D984A02C47D38194BCFF088E31FB',
               '0F2892663861446282F0E2CF2F0F1B13',
               '1076FAAD98D8479281115349FE52A3A6',
               '15A16BD56BFC40679979DDD52C2E73C6',
               '1B01BF3F9F0D4C8EB8A058E159A41278',
               '23B775B032974377A2A03572A70C3739',
               '26FB9494B74749B9B5B21AE1407780E0',
               '306DA3F2469B455AB6483B1FAE382FEE',
               '37626CECCE544EA39EE1F28F6EA55FFF',
               '43AC98D56A7A41148A5D334CF45BD7D5',
               '4408CA7E608F4668A89567123AF48A64',
               '4662E1E73E92465589E2A931A0B24C91',
               '5A04333018C14299B44E9144ED521CE0',
               '5D76365303AC4ADAB933B0094D624910',
               '64E0BC8D4AE4490FA4ADAF31F07E72EC',
               '64ECB3E19B464234ACD7430E898C37DF',
               '729F410EE93440418F96AF82B93C6B3E',
               '7A2855EE1923434F8916EB05BFD71A7C',
               '7ADBBFDA267E4CE792B9CFCF992D98BE',
               '87EE71BE342D4CEEABC073D309ED8D79',
               'A7ED6534C6B5427983941FBE6809B9A8',
               'B7A45CCD0FA54E3D9528615FE3C9E4A4',
               'B958788CFD7645F79EAC701BB2E2B528',
               'C0773DE1C30C493CAE2C0A7366D35D41',
               'DD1D4B13E5534E6C9396CA642EE7C10C',
               'DF5DF84C063E4899BC9547CD65B23297',
               'E16F194C9E3F40269F2183C472844A16',
               'F7BC8EB368884BE7BA8EBDBCA23C943A']
vorderType_arr = ['外市', '本市', '海外']
vtransType_arr = ['空运', '陆运']
vbackType_arr = ['质量问题', '货物不符', '未收到货', '商品错发']


def random_date():
    startdate = datetime.date(2017, 12, 1)
    date = startdate+datetime.timedelta(random.randint(1, 365))
    return ''.join(str(date).split('-'))


def random_select(arr):
    l = len(arr)-1
    return arr[random.randint(0, l)]


def random_select_bad():
    n = random.randint(0, 100)
    if n > 20:
        return '0'
    else:
        return '1'

def random_select_back():
    n = random.randint(0, 100)
    if n > 90:
        return '退货'
    else:
        return random_select(['已发货', '已收货'])


def make_sql():
    vdestination = random_select(vdestination_arr)
    vdeliveryTerminal = vdestination+str(random.randint(1, 5))+'站'
    vgoBad = random_select_bad()
    vitemId = random_select(vitemId_arr)
    vorderDate = random_date()
    vorderStatus = random_select_back( )
    vorderType = random_select(vorderType_arr)
    vtransTemperature = str(round(random.uniform(0, 18), 1))
    vtransType = random_select(vtransType_arr)
    pk = str(uuid.uuid1()).replace('-', '')
    vbackType = ''
    if vorderStatus == '退货':
        vbackType = random_select(vbackType_arr)
    line = "INSERT INTO `f_d_order`(`ID`, `backType`, `deliveryTerminal`, `destination`, `goBad`, `itemId`, `orderDate`, `orderStatus`, `orderType`, `transTemperature`, `transType`) VALUES " + \
        "('"+pk+"', '"+vbackType+"', '"+vdeliveryTerminal+"', '"+vdestination+"', "+vgoBad+", '"+vitemId+"', '" + \
        vorderDate+"', '"+vorderStatus+"', '"+vorderType + \
        "', '"+vtransTemperature+"', '"+vtransType+"');\n"
    return line


with open('C:/f_d_order_new.sql', 'w', encoding='utf-8') as f:
    for i in range(0, 5000):
        f.write(make_sql())
