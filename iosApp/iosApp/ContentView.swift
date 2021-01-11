import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel
    
    var body: some View {
        NavigationView {
            listView()
                .navigationBarTitle("Github Browser")
        }
    }
    
    private func listView() -> AnyView {
        switch viewModel.loadStatus {
        case .loading:
            return AnyView(Text("Loading...").multilineTextAlignment(.center))
        case .result(let user):
            return AnyView(UserInfoRow(user: user))
        case .error(let description):
            return AnyView(Text(description).multilineTextAlignment(.center))
        }
    }
}

extension ContentView {
    enum LoadStatus {
        case loading
        case result(User)
        case error(String)
    }
    
    class ViewModel: ObservableObject {
        let apiClient: GithubClient
        @Published var loadStatus = LoadStatus.loading
        
        init(apiClient: GithubClient) {
            self.apiClient = apiClient
        }
        
        func searchUser(query: String) {
            self.loadStatus = .loading
            apiClient.getUser(query: query) { (user: User?, error: Error?) in
                if let user = user {
                    self.loadStatus = .result(user)
                } else {
                    self.loadStatus = .error(error?.localizedDescription ?? "Failed to get user information")
                }
            }
        }
    }
}
