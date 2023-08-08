<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="bottomNav" class="bg-success">
		<ul class="nav">
			<li class="bottomNavBtn">
				<a href="/main/feed">
					<div class="d-flex justify-content-center">
						<img id="feedBtn" class="bottomNavImg" src="/static/img/feed.png">
					</div>
					<div class="bottomNavText">피드</div>
				</a>
			</li>
			<li class="bottomNavBtn">
				<a href="/main/feed/myfeed">
					<div class="d-flex justify-content-center">
						<img id="myFeedBtn" class="bottomNavImg" src="/static/img/myfeed.png">
					</div>
					<div class="bottomNavText">내 루틴 관리</div>
				</a>			
			</li>
			<li class="bottomNavBtn">
				<a href="/main/myinfo">
					<div class="d-flex justify-content-center">
						<img id="myInfoBtn" class="bottomNavImg" src="/static/img/myinfo.png">
					</div>
					<div class="bottomNavText">내 정보</div>
				</a>			
			</li>
		</ul>
	</div>