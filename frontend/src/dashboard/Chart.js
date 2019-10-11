import React, { useState, useEffect } from 'react';
import { BarChart, Bar, XAxis, YAxis, Label, ResponsiveContainer } from 'recharts';

function createData(time, value) {
  return { time, value };
}

export default function Chart() {

  const [infos, setInfos] = useState([]);


  useEffect(() => {
    fetch('http://localhost:8080/Chavis/Reservation/chart.do')
      .then(response => response.json())
      .then(infos => {
        setInfos(infos);      
      });
  }, []);

  var time = 0;
  
  var zeroToSix = 0;
  for(time; time<6; time++){
    zeroToSix += infos[String(time)];
  }
  var sixToTwelve = 0;
  for(time; time<12; time++){
    sixToTwelve += infos[String(time)];
  }
  var twelveToSix = 0;
  for(time; time<18; time++){
    twelveToSix += infos[String(time)];
  }
  var sixToZero = 0;
  for(time; time<24; time++){
    sixToZero += infos[String(time)];
  }
  
  const data = [
    createData("자정~ 오전 06시", zeroToSix),
    createData("오전 06시~ 정오", sixToTwelve),
    createData("정오 ~ 오후 6시", twelveToSix),
    createData("오후 6시~ 자정", sixToZero)
  ];
  
  return (
    <React.Fragment>
      <ResponsiveContainer>
        <BarChart
          data={data}
          margin={{
            top: 16,
            right: 16,
            bottom: 0,
            left: 24,
          }}
        >
          <XAxis dataKey="time" />
          <YAxis>
            <Label angle={270} position="left" style={
              { textAnchor: 'middle' }
              }>
              예약 수
            </Label>
          </YAxis>
          <Bar dataKey="value" fill="#8884d8" />
        </BarChart>
      </ResponsiveContainer>
    </React.Fragment>
  );
}