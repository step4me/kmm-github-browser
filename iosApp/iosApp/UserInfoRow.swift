//
//  UserInfoRow.swift
//  iosApp
//
//  Created by 배인진 on 2021/01/11.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct UserInfoRow: View {
    var user: User
    
    var body: some View {
        HStack() {
            VStack(alignment: .leading, spacing: 10.0) {
                Text("User name: \(user.name ?? "")")
                // TODO thumbnail, blog url, ...
            }
            Spacer()
        }
    }
}
