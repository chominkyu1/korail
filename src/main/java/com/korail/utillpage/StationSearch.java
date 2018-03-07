package com.korail.utillpage;

import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.korail.domain.TrainScheduleVO;

import java.io.BufferedReader;
import java.io.IOException;

public class StationSearch {
	public List<TrainScheduleVO> getInfo(String arrSearchCode, String depSearchCode) throws Exception {
		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.tago.go.kr/openapi/service/TrainInfoService/getStrtpntAlocFndTrainInfo"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=1kFS1xMjgzoJx1YDeqgQP%2BBl96d5sKmGNPBw7hqUqCiAJveWE%2BY1zFwtaNpqnWzDCoCF2fHg2hW9bHqG6ByPgw%3D%3D"); /*
																														 * Service
																														 * Key
																														 */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode("100", "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder.append(
				"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지 번호 */
		urlBuilder.append("&" + URLEncoder.encode("depPlaceId", "UTF-8") + "="
				+ URLEncoder.encode(depSearchCode, "UTF-8")); /* 출발기차역ID */
		urlBuilder.append("&" + URLEncoder.encode("arrPlaceId", "UTF-8") + "="
				+ URLEncoder.encode(arrSearchCode, "UTF-8")); /* 도착기차역ID */
		urlBuilder.append("&" + URLEncoder.encode("depPlandTime", "UTF-8") + "="
				+ URLEncoder.encode("20161001", "UTF-8")); /* 출발일 */
		urlBuilder.append("&" + URLEncoder.encode("trainGradeCode", "UTF-8") + "="
				+ URLEncoder.encode("00", "UTF-8")); /* 차량종류(KTX,무궁화) */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		String data = sb.toString();

		List<TrainScheduleVO> list = null; // 결과데이터 담을 리스트
		// System.out.println(data); //응답받은 xml문서 xml문서로부터 내가 원하는 값 탐색하기(xml 파싱)
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		XmlPullParser parser = factory.newPullParser(); // 연결하는거 담고
		parser.setInput(new StringReader(data));
		int eventType = parser.getEventType();
		TrainScheduleVO b = null;
		while (eventType != XmlPullParser.END_DOCUMENT) {
			switch (eventType) {
			case XmlPullParser.END_DOCUMENT:// 문서의 끝
				break;
			case XmlPullParser.START_DOCUMENT:
				list = new ArrayList<TrainScheduleVO>();
				break;
			case XmlPullParser.END_TAG: {
				String tag = parser.getName();
				if (tag.equals("item")) {
					list.add(b);
					b = null;
				}
			}

			case XmlPullParser.START_TAG: { // 무조건 시작하면 만남
				String tag = parser.getName();
				switch (tag) {
				case "item":
					b = new TrainScheduleVO();
					break;
				case "adultcharge":
					if (b != null)
						b.setAdultcharge(parser.nextText());
					break;
				case "arrplacename":
					if (b != null)
						b.setArrplacename(parser.nextText());
					break;
				case "arrplandtime":
					if (b != null)
						b.setArrplandtime(parser.nextText());
					break;
				case "depplacename":
					if (b != null)
						b.setDepplacename(parser.nextText());
					break;
				case "depplandtime":
					if (b != null)
						b.setDepplandtime(parser.nextText());
					break;
				case "traingradename":
					if (b != null)
						b.setTraingradename(parser.nextText());
					break;

				}
				break;
			}
			}
			eventType = parser.next();

		}
		for (TrainScheduleVO book : list)
			System.out.println(book);
		return list;
	}

}
